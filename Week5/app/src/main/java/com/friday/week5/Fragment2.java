package com.friday.week5;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "grande";
    private static final String ARG_PARAM2 = "mediano";
    private static final String ARG_PARAM3 = "chico";

    private String grandeStr;
    private String medianoStr;
    private String chicoStr;


    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */

    public static Fragment2 newInstance(String param1, String param2, String param3) {

        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            grandeStr = getArguments().getString(ARG_PARAM1);
            medianoStr = getArguments().getString(ARG_PARAM2);
            chicoStr = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_fragment2, container, false);
        TextView t2 = (TextView)result.findViewById(R.id.textView2);
        TextView t3 = (TextView)result.findViewById(R.id.textView3);
        TextView t4 = (TextView)result.findViewById(R.id.textView4);

        t2.setText(grandeStr);
        t3.setText(medianoStr);
        t4.setText(chicoStr);

        return result;
    }

}
