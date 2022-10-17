package com.leonardo.cart.flow.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leonardo.cart.databinding.FragmentListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listLiveData.observe(viewLifecycleOwner) {
            when (it) {
                ListViewModel.ListStates.EmptyList -> {
                    binding.rvList.visibility = View.GONE
                    binding.tvEmpty.visibility = View.VISIBLE
                }
                is ListViewModel.ListStates.FilledList -> {
                    binding.rvList.visibility = View.VISIBLE
                    binding.tvEmpty.visibility = View.GONE
                }
            }
        }

        viewModel.fetchList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}