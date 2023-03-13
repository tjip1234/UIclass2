package com.example.uiclass2
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Switch
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.uiclass2.databinding.FragmentThird2Binding
import com.example.uiclass2.databinding.FragmentThirdBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment2 : Fragment() {

    private var _binding: FragmentThird2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThird2Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment2_to_Run_the_proces)
        }


        val imageViews = arrayOfNulls<Button>(9) // Replace 4 with the number of ImageViews you want in your array
        imageViews[0] = binding.imageView
        imageViews[1] = binding.imageView2
        imageViews[2] = binding.imageView3
        imageViews[3] = binding.imageView4
        imageViews[4] = binding.imageView5
        imageViews[5] = binding.imageView6
        imageViews[6] = binding.imageView7
        imageViews[7] = binding.imageView8
        imageViews[8] = binding.imageView9
        val isColor1 = Array(imageViews.size) { true }
        for (i in imageViews.indices) {
            imageViews[i]?.setOnClickListener {
                if (isColor1[i]) {
                    imageViews[i]?.setBackgroundColor(Color.parseColor("#FFEC407A")) // Set color 1
                    isColor1[i] = false
                } else {
                    imageViews[i]?.setBackgroundColor(Color.parseColor("#00FFFFFF")) // Set color 2
                    isColor1[i] = true
                }
            }
        }

        val Switches = arrayOfNulls<Switch>(6)
        Switches[0] = binding.switch1
        Switches[1] = binding.switch2
        Switches[2] = binding.switch3
        Switches[3] = binding.switch4
        Switches[4] = binding.switch5
        Switches[5] = binding.switch6
        val isSwitch1 = Array(Switches.size){true}
        for (i in Switches.indices){
            Switches[i]?.setOnClickListener {
                if (isSwitch1[i]){
                    Switches[i]?.setBackgroundColor(Color.parseColor("#FFEC407A")) // Set color 1
                    isSwitch1[i] = false
                }
                else{
                    Switches[i]?.setBackgroundColor(Color.parseColor("#00EC407A")) // Set color 1
                    isSwitch1[i] = true
                }
            }
        }
        binding.textinputbutton.setOnClickListener {
            val textView = TextView(requireContext())
            textView.text = binding.textinput.text
            textView.isClickable = true
            textView.isFocusable = true
            textView.textSize *= 1.2f
            textView.setOnClickListener { view2 ->
                // Create a popup menu and attach it to the text view
                val popupMenu = PopupMenu(requireContext(), textView)

                // Inflate the menu resource file
                popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

                // Set a click listener on the menu items
                popupMenu.setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.menu_item_1 -> {
                            // Do something when menu item 1 is clicked
                            true
                        }
                        R.id.menu_item_2 -> {
                            // Do something when menu item 2 is clicked
                            true
                        }
                        else -> false
                    }
                }

                // Show the popup menu
                popupMenu.show()
                true
            }
            textView.setOnTouchListener { view, event ->
                // Handle touch events on the text view here
                Log.d("TAG", "TextView clicked")
                true
            }
            binding.textNew.addView(textView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}