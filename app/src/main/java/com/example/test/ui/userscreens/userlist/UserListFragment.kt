package com.example.test.ui.userscreens.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : Fragment() {

    private val viewModel: UserListViewModel by viewModels()
    private lateinit var rv: RecyclerView
    private val adapter by lazy {
        UserListAdapter {
            findNavController().navigate(
                UserListFragmentDirections.actionUserListFragmentToUserDetailsFragment(
                    it
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById(R.id.users_rv)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.usersList.observe(viewLifecycleOwner) {
            rv.adapter = adapter.apply {
                submitList(it)
            }
        }
        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(context, getString(R.string.internet_error), Toast.LENGTH_SHORT).show()
        }
    }


}

