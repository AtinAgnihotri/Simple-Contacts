package com.simplemobiletools.contacts.pro.fragments

import android.content.Context
import android.util.AttributeSet
import android.widget.Toast
import com.simplemobiletools.commons.helpers.TAB_FAVORITES
import com.simplemobiletools.contacts.pro.activities.MainActivity
import com.simplemobiletools.contacts.pro.activities.SimpleActivity
import com.simplemobiletools.contacts.pro.dialogs.SelectContactsDialog
import com.simplemobiletools.contacts.pro.helpers.ContactsHelper
import com.simplemobiletools.contacts.pro.models.Contact

class FavoritesFragment(context: Context, attributeSet: AttributeSet) : MyViewPagerFragment(context, attributeSet) {
    override fun fabClicked() {
        finishActMode()
        showAddFavoritesDialog()
    }

    override fun placeholderClicked() {
        showAddFavoritesDialog()
    }

    private fun showAddFavoritesDialog() {

        // region Show if no contacts added
        if (allContacts.size == 0) {
            Toast.makeText(this.context, "No Contacts to favorite", Toast.LENGTH_SHORT).show()
            return
        } else if  (allContacts.size == 1) {
            if (allContacts.get(0).firstName.toString().equals("") || allContacts.get(0).firstName.toString().equals(" ")){
                Toast.makeText(this.context, "No Contacts to favorite", Toast.LENGTH_SHORT).show()
                return
            }
        }
        // endregion

        SelectContactsDialog(activity!!, allContacts, true, false) { addedContacts, removedContacts ->
            ContactsHelper(activity as SimpleActivity).apply {
                addFavorites(addedContacts)
                removeFavorites(removedContacts)
            }

            (activity as? MainActivity)?.refreshContacts(TAB_FAVORITES)
        }
    }
}
