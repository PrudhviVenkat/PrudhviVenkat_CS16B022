package in.ac.iittp.android.accidentalert.feature;

import java.util.UUID;

public class Contact {

    private UUID mId;
    private String mContactName;
    private String mPhoneNumber;

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getContactName() {
        return mContactName;
    }

    public void setContactName(String contactName) {
        mContactName = contactName;
    }

    public Contact(){
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }


}
