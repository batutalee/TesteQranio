package com.teste.tutasqranio;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class LayoutAplicacao extends Fragment {

	private static final String ARG_SECTION_NUMBER = "section_number";
	
	public LayoutAplicacao() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_layout_aplicacao, container, false);
	}

	public static LayoutAplicacao newInstance(int sectionNumber){
		LayoutAplicacao frag = new LayoutAplicacao();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		frag.setArguments(args);
		return frag;
	}
	
}
