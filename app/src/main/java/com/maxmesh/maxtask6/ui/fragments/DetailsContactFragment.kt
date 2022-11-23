package com.maxmesh.maxtask6.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.maxmesh.maxtask6.R
import com.maxmesh.maxtask6.databinding.FragmentContactDetailsBinding
import com.maxmesh.maxtask6.domain.ContactEntity
import com.maxmesh.maxtask6.ui.activity.MainActivity

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
        setDataOnViewFromList()
        clickOnSaveBtn()
    }

    private fun setDataOnViewFromList() {
        with(binding) {
            editName.setText(contactEntity?.firstName)
            editLastName.setText(contactEntity?.surname)
            editPhone.setText(contactEntity?.phoneNumber)
            imageDetails.load(contactEntity?.avatarUrl)
        }
    }

    private fun clickOnSaveBtn() = with(binding) {
        btnSave.setOnClickListener {
            replaceContainer()
            changeData()
        }
    }

    private fun replaceContainer() {
        requireActivity().supportFragmentManager.popBackStack()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ListContactsFragment())
            .commit()
    }

    private fun FragmentContactDetailsBinding.changeData() {
        (requireActivity() as MainActivity)
            .contacts[(requireActivity() as MainActivity).contacts.indexOf(
            contactEntity
        )] =
            ContactEntity(
                contactEntity?.id!!,
                contactEntity?.avatarUrl!!,
                editName.text.toString(),
                editLastName.text.toString(),
                editPhone.text.toString()
            )
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