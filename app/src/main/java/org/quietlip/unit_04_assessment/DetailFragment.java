package org.quietlip.unit_04_assessment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private static final String ANIMAL_NAME = "name";
    private static final String ANIMAL_LINK = "link";
    public static final String ANIMAL_IMAGE = "image";

    private String aName;
    private String aLink;
    private String aImage;

    private TextView fragmentAnimalName;
    private Button fragmentWebsiteButton;
    private CircleImageView fragmentAnimalImage;

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {}

    public static DetailFragment newInstance(String name, String link, String image) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ANIMAL_NAME, name);
        args.putString(ANIMAL_LINK, link);
        args.putString(ANIMAL_IMAGE, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            aName = getArguments().getString(ANIMAL_NAME);
            aLink = getArguments().getString(ANIMAL_LINK);
            aImage = getArguments().getString(ANIMAL_IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_display, container, false);

       fragmentWebsiteButton = view.findViewById(R.id.website_button);
       fragmentAnimalName = view.findViewById(R.id.animal_name_text_view);
       fragmentAnimalImage = view.findViewById(R.id.fragment_image_view);

        Picasso.get()
                .load(aImage)
                .into(fragmentAnimalImage);

       return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(aLink);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String website);
    }
}
