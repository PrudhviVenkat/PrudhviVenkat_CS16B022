package in.ac.iittp.android.accidentalert.feature;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ContactListFragment extends Fragment {
    private RecyclerView mContactRecyclerView;
    private ContactAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        mContactRecyclerView = (RecyclerView) view.findViewById(R.id.contact_recycler_view);
        mContactRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mNameTextView;
        private TextView mPhoneTextView;
        private ImageView mRemoveImageView;
        private Contact mContact;

        public ContactHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_contact, parent, false));
            itemView.setOnClickListener(this);

            mNameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            mPhoneTextView = (TextView) itemView.findViewById(R.id.phone_number);
            mRemoveImageView = (ImageView) itemView.findViewById(R.id.remove_contact);
        }

        public void bind(Contact contact){
            mContact = contact;
            mNameTextView.setText(mContact.getContactName());
            mPhoneTextView.setText(mContact.getPhoneNumber());
        }

        @Override
        public void onClick(View view){
            Toast.makeText(getContext(), mContact.getContactName() + " Clicked!", Toast.LENGTH_SHORT).show();
            if(mRemoveImageView.getVisibility()==View.GONE) mRemoveImageView.setVisibility(View.VISIBLE);
            else mRemoveImageView.setVisibility(View.GONE);
        }
    }

    private class ContactAdapter extends RecyclerView.Adapter<ContactHolder>{
        private List<Contact> mContacts;

        public ContactAdapter(List<Contact> contacts){
            mContacts = contacts;
        }

        @Override
        public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ContactHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(ContactHolder holder, int position) {
            Contact contact = mContacts.get(position);
            holder.bind(contact);
        }
        @Override
        public int getItemCount() {
            return mContacts.size();
        }
    }

    private void updateUI(){
        ContactLab contactLab = ContactLab.get(getActivity());
        List<Contact> contacts = contactLab.getContacts();
        mAdapter = new ContactAdapter(contacts);
        mContactRecyclerView.setAdapter(mAdapter);
    }
}
