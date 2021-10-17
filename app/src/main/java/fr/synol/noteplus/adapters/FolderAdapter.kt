package fr.synol.noteplus.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import fr.synol.noteplus.MainActivity
import fr.synol.noteplus.R
import fr.synol.noteplus.models.FolderModel

class FolderAdapter(
    private val context: MainActivity,
    private val folderList: List<FolderModel>,
    private val layoutId: Int
) : RecyclerView.Adapter<FolderAdapter.ViewHolder>() {

    /// Box for regroup all components
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val folderName: TextView? = view.findViewById(R.id.folder_name)
        val folderDescription: TextView? = view.findViewById(R.id.folder_description)
        val starIcon: ImageView = view.findViewById(R.id.star_icon)
        val lockIcon: ImageView? = view.findViewById(R.id.lock_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentFolder = folderList[position]

        holder.folderName?.text = currentFolder.name
        holder.folderDescription?.text = currentFolder.notesCount.toString() + " note(s)"

        if (currentFolder.pinned) {
            holder.starIcon.setImageResource(R.drawable.ic_pinned)
            DrawableCompat.setTint(
                DrawableCompat.wrap(holder.starIcon.drawable).mutate(),
                ContextCompat.getColor(context, R.color.orange))
        }
        else {
            holder.starIcon?.setImageResource(R.drawable.ic_unpinned)
            DrawableCompat.setTint(
                DrawableCompat.wrap(holder.starIcon.drawable).mutate(),
                ContextCompat.getColor(context, R.color.light_grey))
        }

        if (currentFolder.locked) holder.lockIcon?.visibility = View.VISIBLE
        else holder.lockIcon?.visibility = View.INVISIBLE
    }

    override fun getItemCount(): Int = folderList.size


}