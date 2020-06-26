package com.ransoft.androidroom.simplifiedcoading.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ransoft.androidroom.R
import com.ransoft.androidroom.simplifiedcoading.data.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.android.synthetic.main.fragment_home.*

class AddNoteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        NoteDatabase(requireActivity())

        btn_done.setOnClickListener {
            val action = AddNoteFragmentDirections.actionSaveNote()
            Navigation.findNavController(it).navigate(action)
        }
    }
}