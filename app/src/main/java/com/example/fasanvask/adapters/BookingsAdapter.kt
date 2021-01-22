package sh.mama.hangman.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fasanvask.R
import com.example.fasanvask.models.Booking
import kotlinx.android.synthetic.main.booking_card.view.*

class BookingsAdapter(
    private var events: List<Booking>,
) : RecyclerView.Adapter<BookingsAdapter.BookingViewHolder>() {

    inner class BookingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.booking_card, parent, false)
        return BookingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        val event = events[position]
        holder.itemView.apply {
            hej.text = event.id
        }
    }

    override fun getItemCount(): Int {
        return events.size
    }
}