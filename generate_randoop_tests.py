#!/usr/bin/env python3
"""
Script to automate Randoop test generation for Parking Management System
"""

import os
import subprocess
import shutil
import glob
import argparse
import sys

def run_command(command, cwd=None):
    """Run a command and return the output"""
    print(f"Running: {command}")
    result = subprocess.run(command, shell=True, capture_output=True, text=True, cwd=cwd)
    if result.returncode != 0:
        print(f"Error executing command: {command}")
        print(f"Error output: {result.stderr}")
        return False
    return True

def clean_and_compile():
    """Clean and compile the project"""
    print("Step 1: Cleaning and compiling the project...")
    if not run_command("mvn clean"):
        return False
    if not run_command("mvn compile"):
        return False
    return True

def generate_tests(class_names, output_limit=500):
    """Generate tests using Randoop"""
    print("Step 2: Generating tests with Randoop...")
    
    # Create a comma-separated list of classes
    class_list = ",".join(class_names)
    
    # Get current directory
    current_dir = os.getcwd()
    
    # Randoop command
    randoop_cmd = (
        f"java -classpath {current_dir}/target/classes/:{current_dir}/randoop-lib/randoop-all-4.2.1.jar "
        f"randoop.main.Main gentests --testclass={class_list} --output-limit={output_limit}"
    )
    
    if not run_command(randoop_cmd):
        return False
    return True

def clean_temp_files():
    """Clean temporary files"""
    print("Step 3: Cleaning temporary files...")
    for file in glob.glob("*.class"):
        os.remove(file)
    return True

def update_package_name(test_files, package_name):
    """Update package name in test files"""
    print("Step 4: Updating package name in test files...")
    for file in test_files:
        if os.path.exists(file):
            with open(file, "r") as f:
                content = f.read()
            
            # Add package declaration at the beginning
            content = f"package {package_name};\n\n{content}"
            
            with open(file, "w") as f:
                f.write(content)
    return True

def move_test_files(test_files, target_dir):
    """Move test files to target directory"""
    print("Step 5: Moving test files to test directory...")
    os.makedirs(target_dir, exist_ok=True)
    
    for file in test_files:
        if os.path.exists(file):
            filename = os.path.basename(file)
            target_file = os.path.join(target_dir, filename)
            shutil.move(file, target_file)
    return True

def run_tests(test_classes):
    """Run the generated tests"""
    print("Step 6: Running the generated tests...")
    for test_class in test_classes:
        if not run_command(f"mvn test -Dtest={test_class}"):
            print(f"Warning: Test {test_class} failed.")
    return True

def parse_arguments():
    """Parse command line arguments"""
    parser = argparse.ArgumentParser(description='Generate Randoop tests for Parking Management System')
    parser.add_argument('--classes', required=False, help='Comma-separated list of classes to test', 
                        default='com.example.parking.model.Booking,com.example.parking.model.Client,com.example.parking.model.FacultyMember,com.example.parking.model.ParkingSpace')
    parser.add_argument('--output-limit', type=int, required=False, help='Number of tests to generate', default=500)
    parser.add_argument('--package', required=False, help='Package name for test files', default='com.example.parking.test.randoop')
    parser.add_argument('--test-dir', required=False, help='Directory for test files', default='src/test/java/com/example/parking/test/randoop')
    
    return parser.parse_args()

def main():
    """Main function"""
    args = parse_arguments()
    
    # Split comma-separated list of classes
    class_names = args.classes.split(',')
    output_limit = args.output_limit
    package_name = args.package
    test_dir = args.test_dir
    
    # Clean and compile
    if not clean_and_compile():
        print("Failed to clean and compile the project.")
        return 1
    
    # Generate tests
    if not generate_tests(class_names, output_limit):
        print("Failed to generate tests.")
        return 1
    
    # Clean temporary files
    if not clean_temp_files():
        print("Failed to clean temporary files.")
        return 1
    
    # Find generated test files
    test_files = glob.glob("RegressionTest*.java") + glob.glob("ErrorTest*.java")
    
    if not test_files:
        print("No test files were generated.")
        return 1
    
    # Update package name
    if not update_package_name(test_files, package_name):
        print("Failed to update package name.")
        return 1
    
    # Move test files
    if not move_test_files(test_files, test_dir):
        print("Failed to move test files.")
        return 1
    
    # Generate test class names with package
    test_classes = [f"{package_name}.{os.path.splitext(os.path.basename(file))[0]}" for file in test_files]
    
    # Run tests
    if not run_tests(test_classes):
        print("Some tests failed.")
    
    print("Randoop test generation completed successfully!")
    return 0

if __name__ == "__main__":
    sys.exit(main())