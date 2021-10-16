package fr.synol.noteplus.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.synol.noteplus.R
import fr.synol.noteplus.adapters.FolderAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        val folderRecyclerView = view.findViewById<RecyclerView>(R.id.folder_recycler_view)
        folderRecyclerView.adapter = FolderAdapter()

        return view;
    }

}