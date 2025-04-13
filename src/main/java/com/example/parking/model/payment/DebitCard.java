package com.example.parking.model.payment;

public class DebitCard extends PaymentMethod {

    private String cardHolderName;
    private String pin; // e.g. "1234"

    public DebitCard(String cardNumber, String cardHolderName, String pin, double amount) {
        super("debit", cardNumber, pin, amount); // Pass type, cardNumber, and credential (PIN) to super
        this.cardHolderName = cardHolderName; // Initialize cardHolderName
        this.pin = pin; // Initialize PIN
    }

    @Override
    public boolean processPayment(double amount) {
        // 1. Validate the debit card number
        if (!isValidCardNumber(getCardNumber())) { // Use getCardNumber() from superclass
            System.out.println("Transaction failed: invalid debit card number.");
            return false;
        }

        // 2. Validate the PIN
        if (!isValidPin(pin)) {
            System.out.println("Transaction failed: incorrect PIN.");
            return false;
        }

        // 3. Mask the card number
        String masked = maskCardNumber(getCardNumber()); // Use getCardNumber() from superclass

        // 4. Check amount
        if (amount <= 0) {
            System.out.println("Transaction failed: amount must be greater than 0.");
            return false;
        }

        // 5. Approve payment
        System.out.println("Debit card payment of $" + amount + " approved for cardholder " 
            + cardHolderName + " using card " + masked + " with valid PIN.");
        // Additional logic: deduct from bank account, record transaction, etc.
        return true;
    }

    @Override
    public void processRefund(double amount) {
        if (!isValidCardNumber(getCardNumber())) { // Use getCardNumber() from superclass
            System.out.println("Refund failed: invalid debit card number.");
            return;
        }

        if (!isValidPin(pin)) {
            System.out.println("Refund failed: incorrect PIN.");
            return;
        }

        String masked = maskCardNumber(getCardNumber()); // Use getCardNumber() from superclass
        System.out.println("Debit card refund of $" + amount + " processed for cardholder " 
            + cardHolderName + " using card " + masked + " with valid PIN.");
    }

    /**
     * Example validation: a 16-digit numeric card number.
     */
    private boolean isValidCardNumber(String number) {
        return number.matches("\\d{16}");
    }

    /**
     * Example PIN validation: exactly 4 digits.
     */
    private boolean isValidPin(String pin) {
        return pin.matches("\\d{4}");
    }

    /**
     * Mask the card number to hide all but the last four digits.
     */
    private String maskCardNumber(String number) {
        if (number.length() <= 4) {
            return number;
        }
        String last4 = number.substring(number.length() - 4);
        return "************" + last4;
    }

    public Object getCardHolderName() {
        return cardHolderName;
    }
}