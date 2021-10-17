package fr.synol.noteplus.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.synol.noteplus.MainActivity
import fr.synol.noteplus.R
import fr.synol.noteplus.adapters.FolderAdapter
import fr.synol.noteplus.adapters.FolderItemDecoration
import fr.synol.noteplus.models.FolderModel

class HomeFragment(
    private val context: MainActivity
) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        val folderList = arrayListOf<FolderModel>()

        folderList.add(FolderModel("Test", 5))
        folderList.add(FolderModel("Almazia", 18, pinned = true, locked = true))
        folderList.add(FolderModel())
        folderList.add(FolderModel())
        folderList.add(FolderModel())
        folderList.add(FolderModel())
        folderList.add(FolderModel())
        folderList.add(FolderModel())
        folderList.add(FolderModel())
        folderList.add(FolderModel("jsklhfs"))

        val folderRecyclerView = view.findViewById<RecyclerView>(R.id.folder_recycler_view)
        folderRecyclerView.adapter = FolderAdapter(context, folderList, R.layout.item_folder)
        folderRecyclerView.addItemDecoration(FolderItemDecoration())

        return view;
    }

}