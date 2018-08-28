package in.ac.iittp.android.accidentalert.feature;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ImageView mAlertSwitch;
    private TextView mRequestText;
    public int mSwitch = 0;


    public HomeFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        mAlertSwitch = (ImageView) v.findViewById(R.id.alert_switch);
        mRequestText = (TextView) v.findViewById(R.id.request_msg);

        if (((MainActivity)getActivity()).getAlertSwitch() == 1) {
            mAlertSwitch.setImageResource(R.drawable.init_alert_system);
            mRequestText.setText(R.string.request_off);
        } else {
            mAlertSwitch.setImageResource(R.drawable.off_alert_system);
            mRequestText.setText(R.string.request_on);
        }

        mAlertSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MainActivity)getActivity()).getAlertSwitch() == 0) {
                    mAlertSwitch.setImageResource(R.drawable.init_alert_system);
                    mRequestText.setText(R.string.request_off);
                    ((MainActivity)getActivity()).setAlertSwitch(1);
                } else {
                    mAlertSwitch.setImageResource(R.drawable.off_alert_system);
                    mRequestText.setText(R.string.request_on);
                    ((MainActivity)getActivity()).setAlertSwitch(0);
                }
            }
        });
        return v;
    }

}
