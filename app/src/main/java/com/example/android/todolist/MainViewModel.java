package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    //Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        tasks = database.taskDao().loadAllTasks();
    }

    public LiveData<List<TaskEntry>> getTasks(){
        return tasks;
    }
}
