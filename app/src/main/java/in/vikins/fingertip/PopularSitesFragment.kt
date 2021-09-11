package `in`.vikins.fingertip

import `in`.vikins.fingertip.databinding.FragmentPopularSitesBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController


class PopularSitesFragment : Fragment() {
    private lateinit var binding: FragmentPopularSitesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularSitesBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        return  binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popuralsite()

    }
    fun navigate(link:String){
        val directions=
            `in`.vikins.fingertip.PopularSitesFragmentDirections.actionPopularSitesFragmentToWebSearchFragment(
                link
            )

        findNavController().navigate(directions)
    }
    fun popuralsite(){
        var link: String
        binding.amazon.setOnClickListener {
            link = "https://www.amazon.in/"
            navigate(link)
        }
        binding.flipkart.setOnClickListener {
            link = "https://www.flipkart.com/"
            navigate(link)
        }
        binding.messo.setOnClickListener {
            link = "https://meesho.com/"
            navigate(link)
        }
        binding.snapdeal.setOnClickListener {
            link = "https://www.snapdeal.com/"
            navigate(link)
        }
        binding.myntra.setOnClickListener {
            link = "https://www.myntra.com/"
            navigate(link)
        }
        binding.twitter.setOnClickListener {
            link = "https://twitter.com/"
            navigate(link)
        }
        binding.facebook.setOnClickListener {
            link = "https://www.facebook.com/"
            navigate(link)
        }
        binding.instagram.setOnClickListener {
            link = "https://www.instagram.com/"
            navigate(link)
        }
        binding.youtube.setOnClickListener {
            link = "https://www.youtube.com/"
            navigate(link)
        }
        binding.primevideo.setOnClickListener {
            link = "https://www.primevideo.com/"
            navigate(link)
        }
        binding.hotstar.setOnClickListener {
            link = "https://www.hotstar.com/in"
            navigate(link)
        }
        binding.mxplayer.setOnClickListener {
            link = "https://www.mxplayer.in/"
            navigate(link)
        }
        binding.toi.setOnClickListener {
            link = "https://timesofindia.indiatimes.com/"
            navigate(link)
        }
        binding.theprint.setOnClickListener {
            link = "https://theprint.in/"
            navigate(link)
        }
        binding.telegraph.setOnClickListener {
            link = "https://www.telegraphindia.com/"
            navigate(link)
        }
        binding.thehindu.setOnClickListener {
            link = "https://www.thehindu.com/"
            navigate(link)
        }
    }
}