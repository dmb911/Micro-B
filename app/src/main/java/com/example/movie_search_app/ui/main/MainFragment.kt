package com.example.movie_search_app.ui.main

import android.app.AlertDialog
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.*
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_search_app.adapter.MyMovieAdapter
import com.example.movie_search_app.common.Common
import com.example.movie_search_app.databinding.FragmentMainBinding
import com.example.movie_search_app.interfaces.RetrofitServices
import com.example.movie_search_app.model.Movie
import com.google.gson.JsonObject
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.fragment_main.*
import org.xml.sax.Parser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URL


open class MainFragment : Fragment() {
    private lateinit var mainViewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mService = Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(activity)
        recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(activity).build()
        getAllMovieList()





    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val rootview: View = binding.root

       /* val textView: TextView = binding.textFavorites
        mainViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return rootview
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun getAllMovieList() {
       dialog.show()
       mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
           override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {

           }

           override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
               adapter = MyMovieAdapter(requireActivity(), response.body() as MutableList<Movie>)
               adapter.notifyDataSetChanged()
               recyclerMovieList.adapter = adapter

               dialog.dismiss()
           }
       })
   }





}



