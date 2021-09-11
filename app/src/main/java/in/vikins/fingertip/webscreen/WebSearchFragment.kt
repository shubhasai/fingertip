package `in`.vikins.fingertip.webscreen

import `in`.vikins.fingertip.R
import `in`.vikins.fingertip.databinding.FragmentWebSearchBinding
import `in`.vikins.fingertip.homescreen.HomeFragmentDirections
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.android.HandlerDispatcher

class WebSearchFragment : Fragment() {
    private lateinit var binding:FragmentWebSearchBinding
    val args: WebSearchFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebSearchBinding.inflate(layoutInflater)
        val url = args.url
        val webv = binding.webview
        webv.webViewClient = WebViewClient()
        webv.loadUrl(url)
        webv.settings.javaScriptEnabled = true
        webv.settings.allowFileAccess = true
        webv.settings.allowContentAccess = true
        webv.settings.domStorageEnabled = true
        webv.settings.useWideViewPort = true
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if(shouldInterceptBackPress()){
                    if(webv.canGoBack()){
                        webv.goBack()
                    }
                    else{
                        val directions = WebSearchFragmentDirections.actionWebSearchFragmentToHomeFragment()
                        findNavController().navigate(directions)
                    }

                }else{
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        })
        return binding.root
    }
    fun shouldInterceptBackPress() = true
}