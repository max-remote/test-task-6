package com.maxmesh.maxtask6.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.maxmesh.maxtask6.R
import com.maxmesh.maxtask6.databinding.ContactItemBinding
import com.maxmesh.maxtask6.domain.ContactEntity

class ContactsAdapter :
    ListAdapter<ContactEntity, ContactsAdapter.ContactsViewHolder>(Comparator()) {

    var onItemClickListener: ((ContactEntity) -> Unit)? = null
    var onItemLongClickListener: ((ContactEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ContactsViewHolder(parent)

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ContactsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
    ) {
        private val binding = ContactItemBinding.bind(itemView)

        fun bind(contactEntity: ContactEntity) = with(binding) {
            itemImage.load(contactEntity.avatarUrl)
            itemFirstName.text = contactEntity.firstName
            itemSurname.text = contactEntity.surname
            itemNumber.text = contactEntity.phoneNumber

            cardView.setOnClickListener {
                onItemClickListener?.invoke(contactEntity)
            }

            cardView.setOnLongClickListener {
                onItemLongClickListener?.invoke(contactEntity)
                true
            }
        }
    }

    class Comparator :
        DiffUtil.ItemCallback<ContactEntity>() {
        override fun areItemsTheSame(oldItem: ContactEntity, newItem: ContactEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ContactEntity, newItem: ContactEntity): Boolean {
            return oldItem == newItem
        }
    }
}