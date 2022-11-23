package com.maxmesh.maxtask6.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.maxmesh.maxtask6.databinding.FragmentContactDetailsBinding
import com.maxmesh.maxtask6.domain.ContactEntity

class DetailsContactFragment : Fragment() {

    private var _binding: FragmentContactDetailsBinding? = null
    private val binding get() = _binding!!
    private var contactEntity: ContactEntity? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { contactEntity = it.getParcelable(SAVE_CONTACT) }
        setDataOnView()
    }

    private fun setDataOnView() {
        with(binding) {
            editName.setText(contactEntity?.firstName)
            editLastName.setText(contactEntity?.surname)
            editPhone.setText(contactEntity?.phoneNumber)
            imageDetails.load(contactEntity?.avatarUrl)
        }
    }

    companion object {
        private const val SAVE_CONTACT = "save_contact"

        fun newInstance(contactEntity: ContactEntity) =
            DetailsContactFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(SAVE_CONTACT, contactEntity)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}