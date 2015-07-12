package com.teste.tutasqranio;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class LayoutMeuPerfil extends Fragment {

	private static final String ARG_SECTION_NUMBER = "section_number";
	
	public LayoutMeuPerfil() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_layout_meu_perfil, container, false);
	}

	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
	}
	
	public static LayoutMeuPerfil newInstance(int sectionNumber){
		LayoutMeuPerfil frag = new LayoutMeuPerfil();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		frag.setArguments(args);
		return frag;
	}
	
}
