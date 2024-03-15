package com.example.test.ui.userscreens.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.test.R
import com.example.test.databinding.FragmentUserDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailsFragment : Fragment() {

    private val args by navArgs<UserDetailsFragmentArgs>()
    private val userData by lazy {
        args.userData
    }

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentUserDetailsBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUserData()
        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setUserData() {
        binding.textViewName.text = String.format(getString(R.string.user_name), userData.name)
        binding.textViewUserName.text =
            String.format(getString(R.string.user_login), userData.userName)
        binding.textViewEmail.text = String.format(getString(R.string.user_email), userData.email)
        binding.textViewAddress.text =
            String.format(getString(R.string.user_address), userData.address)
        binding.textViewPhone.text = String.format(getString(R.string.user_phone), userData.phone)
        binding.textViewWebsite.text =
            String.format(getString(R.string.user_site), userData.website)
        binding.textViewCompany.text =
            String.format(getString(R.string.user_company), userData.company)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}