package com.example.fileshelf;

import android.content.Context;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileViewHolder> {
    private Context context;
    private List<File> file;
    private OnFileSelectedListener listener;

    public FileAdapter(Context context, List<File> file, OnFileSelectedListener listener) {
        this.context = context;
        this.file = file;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FileViewHolder(LayoutInflater.from(context).inflate(R.layout.file_container, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull FileViewHolder holder, int position) {
        holder.tvName.setText(file.get(position).getName());
        holder.tvName.setSelected(true);
        int items = 0;
        if(file.get(position).isDirectory()){
            File[] files = file.get(position).listFiles();
            for (File singleFile : files){
                if(!singleFile.isHidden()){
                    items+=1;
                }
            }
            holder.tvSize.setText(String.valueOf(items) + " Files");
        }
        else{
            holder.tvSize.setText(Formatter.formatShortFileSize(context,file.get(position).length()));

        }
        if(file.get(position).getName().toLowerCase().endsWith(".jpeg")){
            holder.imgFile.setImageResource(R.drawable.ic_photos);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".jpg")) {
            holder.imgFile.setImageResource(R.drawable.ic_photos);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".png")) {
            holder.imgFile.setImageResource(R.drawable.ic_photos);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".mp3")) {
            holder.imgFile.setImageResource(R.drawable.ic_musicxml);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".wav")) {
            holder.imgFile.setImageResource(R.drawable.ic_musicxml);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".m4a")) {
            holder.imgFile.setImageResource(R.drawable.ic_musicxml);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".mp4")) {
            holder.imgFile.setImageResource(R.drawable.ic_video);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".mov")) {
            holder.imgFile.setImageResource(R.drawable.ic_video);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".pdf")) {
            holder.imgFile.setImageResource(R.drawable.ic_pdfxml);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".doc")) {
            holder.imgFile.setImageResource(R.drawable.ic_doc);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".docx")) {
            holder.imgFile.setImageResource(R.drawable.ic_doc);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".apk")) {
            holder.imgFile.setImageResource(R.drawable.ic_apk);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".xls")) {
            holder.imgFile.setImageResource(R.drawable.ic_excel);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".xlsx")) {
            holder.imgFile.setImageResource(R.drawable.ic_excel);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".pptx")) {
            holder.imgFile.setImageResource(R.drawable.ic_ppt);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".ppt")) {
            holder.imgFile.setImageResource(R.drawable.ic_ppt);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".txt")) {
            holder.imgFile.setImageResource(R.drawable.ic_txt);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".html")) {
            holder.imgFile.setImageResource(R.drawable.ic_html);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".htm")) {
            holder.imgFile.setImageResource(R.drawable.ic_html);
        }
         else if(file.get(position).getName().toLowerCase().endsWith(".odp")) {
            holder.imgFile.setImageResource(R.drawable.ic_doc);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".gif")) {
            holder.imgFile.setImageResource(R.drawable.ic_gif);
        }
        else if(file.get(position).getName().toLowerCase().endsWith(".psd")) {
            holder.imgFile.setImageResource(R.drawable.ic_psd);
        }
        else{
            holder.imgFile.setImageResource(R.drawable.folder);
        }

        holder.container.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                listener.onFileClicked(file.get(position));
            }
        });

        holder.container.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                listener.onFileLongClicked(file.get(position), position);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return file.size();
    }
}
