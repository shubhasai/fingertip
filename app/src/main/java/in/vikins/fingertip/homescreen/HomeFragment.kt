package `in`.vikins.fingertip.homescreen

import `in`.vikins.fingertip.databinding.FragmentHomeBinding
import `in`.vikins.fingertip.homescreen.models.News

import `in`.vikins.fingertip.homescreen.viewmodel.HomeViewModel
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(),newsItemClicked {
    private lateinit var binding: FragmentHomeBinding
    lateinit var recyclerAdapter: HomeRecyclerAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //launch Mode or Intent.flags

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerAdapter = HomeRecyclerAdapter(activity as Context,this)
        binding.recyclerView.adapter = recyclerAdapter
        val viewmodel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewmodel.makeapicall()
        viewmodel.getRecyclerlistObserver().observe(viewLifecycleOwner, Observer {
            recyclerAdapter.setupdateDada(it.articles)
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgsearch.setOnClickListener {
            val q = binding.editTextTextPersonName.text
            val directions= HomeFragmentDirections.actionHomeFragmentToWebSearchFragment2("https://www.google.com/search?q="+q)

            findNavController().navigate(directions)

        }

    }
    override fun onitemClicked(itemlist: News) {
        val directions= HomeFragmentDirections.actionHomeFragmentToWebSearchFragment2(itemlist.url)
        findNavController().navigate(directions)
    }

}