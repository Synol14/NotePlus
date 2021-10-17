package fr.synol.noteplus.models

class FolderModel(
    val name: String = "Folder Name",
    val notesCount: Int = 0,
    val pinned: Boolean = false,
    val locked: Boolean = false
)