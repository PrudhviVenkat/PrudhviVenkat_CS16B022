package in.ac.iittp.android.accidentalert.feature;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactLab {
    private static ContactLab sContactLab;

    private List<Contact> mContacts;

    public static ContactLab get(Context context){
        if(sContactLab == null) sContactLab = new ContactLab(context);
        return sContactLab;
    }

    private ContactLab(Context context){
        mContacts = new ArrayList<>();
        for(int i=1; i<10; i++){
            Contact contact = new Contact();
            contact.setContactName("Contact #" + i);
            contact.setPhoneNumber("91+"+1000000000*i);
            mContacts.add(contact);
        }
    }

    public List<Contact> getContacts(){
        return mContacts;
    }

    public Contact getContact(UUID id){
        for(Contact contact : mContacts){
            if(contact.getId().equals(id)){
                return contact;
            }
        }
        return null;
    }
}
