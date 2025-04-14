#!/usr/bin/env python3


import os
import subprocess
import shutil
import glob
import argparse
import sys

def run_command(command, cwd=None):

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

def parse_arguments():
    """Parse command line arguments"""
    parser = argparse.ArgumentParser(description='Generate Randoop tests for Parking Management System')
    parser.add_argument('--classes', required=False, help='Comma-separated list of classes to test', 
                        default='com.example.parking.model.Booking,com.example.parking.model.Client,com.example.parking.model.FacultyMember,com.example.parking.model.ParkingSpace,com.example.parking.model.Student,com.example.parking.model.Visitor,com.example.parking.model.Sensor,com.example.parking.model.Car,com.example.parking.model.PaymentMethod,com.example.parking.model.CreditCard,com.example.parking.model.MobilePayment,com.example.parking.service.BookingService,com.example.parking.service.ClientService,com.example.parking.service.ParkingSpaceService,com.example.parking.service.PaymentService')
    parser.add_argument('--output-limit', type=int, required=False, help='Number of tests to generate', default=1000)
    parser.add_argument('--package', required=False, help='Package name for test files', default='com.example.parking.test.randoop')
    parser.add_argument('--test-dir', required=False, help='Directory for test files', default='src/test/java/com/example/parking/test/randoop')
    
    return parser.parse_args()

def generate_tests(class_names, output_limit=1000):
    """Generate tests using Randoop"""
    print("Step 2: Generating tests with Randoop...")
    
    # Create a comma-separated list of classes
    class_list = ",".join(class_names)
    
    # Get current directory
    current_dir = os.getcwd()
    
    # Randoop command - using main class with improved configuration
    randoop_cmd = (
        f"java -cp {current_dir}\\target\\classes;{current_dir}\\randoop-lib\\randoop-all-4.3.2.jar "
        f"randoop.main.Main gentests "
        f"--testclass={class_list} "
        f"--output-limit={output_limit} "
        f"--junit-output-dir=src/test/java "
        f"--junit-package-name={os.path.basename(os.path.normpath(os.path.join(current_dir, 'src/test/java')))} "
        f"--timelimit=60 "
        f"--forbid-null=false "
        f"--call-timeout=2000 "
        f"--max-array-size=100 "
        f"--max-string-length=100 "
        f"--max-stack-depth=100 "
        f"--max-sequence-length=100 "
        f"--max-sequence-size=100 "
        f"--max-array-length=100 "
        f"--max-array-size=100 "
        f"--max-string-length=100 "
        f"--max-stack-depth=100 "
        f"--max-sequence-length=100 "
        f"--max-sequence-size=100 "
        f"--max-array-length=100 "
        f"--max-array-size=100 "
        f"--max-string-length=100 "
        f"--max-stack-depth=100 "
        f"--max-sequence-length=100 "
        f"--max-sequence-size=100 "
        f"--max-array-length=100 "
        f"--max-array-size=100 "
        f"--max-string-length=100 "
        f"--max-stack-depth=100 "
        f"--max-sequence-length=100 "
        f"--max-sequence-size=100 "
        f"--max-array-length=100 "
        f"--max-array-size=100 "
    )
    
    if not run_command(randoop_cmd):
        return False
    return True

def main():
    args = parse_arguments()
    class_names = args.classes.split(',')
    output_limit = args.output_limit
    package_name = args.package
    test_dir = args.test_dir
    
    if not clean_and_compile():
        print("Failed to clean and compile the project.")
        return
    
    if not generate_tests(class_names, output_limit):
        print("Failed to generate Randoop tests.")
        return
    
    print("Randoop tests generated successfully.")

if __name__ == "__main__":
    main()