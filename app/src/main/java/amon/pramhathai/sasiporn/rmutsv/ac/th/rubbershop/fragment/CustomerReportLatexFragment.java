package amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.CustomerActivity;
import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.OwnerActivity;
import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.R;

/**
 * Created by sasiporn on 2/14/2018 AD.
 */

public class CustomerReportLatexFragment extends Fragment {

    private String[] loginStrings;

    public static CustomerReportLatexFragment customerReportLatexInstance (String[] loginStrings) {
        CustomerReportLatexFragment customerReportLatexFragment = new CustomerReportLatexFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login", loginStrings);
        customerReportLatexFragment.setArguments(bundle);
        return customerReportLatexFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loginStrings = getArguments().getStringArray("Login");

//        Create Toolbar
        createToolbar();


    }   // main method

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarReportLatex);
        ((CustomerActivity)getActivity()).setSupportActionBar(toolbar);

        ((CustomerActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.latex_report));
        ((CustomerActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.customer_login) + loginStrings[1]);

        ((CustomerActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((CustomerActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        setHasOptionsMenu(true);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_report_latex, container, false);
        return view;                                            //  มาจากการกด Alt+Enter
    }


}   // main class
