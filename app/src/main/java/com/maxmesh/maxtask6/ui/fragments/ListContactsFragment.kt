package com.maxmesh.maxtask6.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maxmesh.maxtask6.R
import com.maxmesh.maxtask6.databinding.FragmentContactsListBinding
import com.maxmesh.maxtask6.ui.activity.MainActivity
import com.maxmesh.maxtask6.ui.adapter.ContactsAdapter

class ListContactsFragment : Fragment() {

    private var _binding: FragmentContactsListBinding? = null
    private val binding get() = _binding!!
    private val adapter = ContactsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        clickOnItemListener()
    }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = adapter
        adapter.submitList((requireActivity() as MainActivity).contacts)
    }

    private fun clickOnItemListener() {
        adapter.onItemClickListener = { contact ->
            requireActivity().supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(
                    R.id.container,
                    DetailsContactFragment.newInstance(contact)
                )
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

