package pl.edu.agh.internetshop;


import java.math.BigInteger;

public class MoneyTransfer {
    private final BigInteger accNumber;
    private final String ownerDetails;
    private final String description;
    private final int amount;
    private boolean committedSuccessfully;

    public MoneyTransfer(BigInteger accNumber, String ownerDetails, String description, int amount) {
        this.accNumber = accNumber;
        this.ownerDetails = ownerDetails;
        this.description = description;
        this.amount = amount;
        committedSuccessfully = false;
    }

    public BigInteger getAccNumber() {
        return accNumber;
    }

    public String getOwnerDetails() {
        return ownerDetails;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isCommitedSuccessfully() {
        return committedSuccessfully;
    }

    public void setCommittedSuccessfully(boolean committed) {
        this.committedSuccessfully = committed;
    }
}
