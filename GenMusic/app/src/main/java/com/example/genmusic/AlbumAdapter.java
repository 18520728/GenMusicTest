package com.example.genmusic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    //Tạo list chứa các thể loại
    private List<Album> ListAlbum;

    //Hàm đổ dữ liệu vào List
    public void setData(List<Album> list)
    {
        this.ListAlbum = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);

        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {

        Album album = ListAlbum.get(position);
        if(album == null)
            return;
        else
        {
            holder.imgAlbum.setImageResource(album.getImgId());
            holder.txtTieuDeAlbum.setText(album.getTieuDe());
        }

    }

    @Override
    public int getItemCount() {

        if(ListAlbum != null)
        {
            return ListAlbum.size();
        }
        return 0;
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAlbum;
        private TextView txtTieuDeAlbum;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAlbum = itemView.findViewById(R.id.imgAlbum);
            txtTieuDeAlbum = itemView.findViewById(R.id.txtTieuDeAlbum);

        }
    }
}
