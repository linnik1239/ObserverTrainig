package com.example.practice21observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.practice21observer.data.network.MyApi
import com.example.practice21observer.data.network.MyApi2
import com.example.practice21observer.data.repositories.RetrofitClient
import com.example.practice21observer.models.PostResponse
import io.reactivex.Flowable.just
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single.just
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.function.Predicate


// Disposable:  Something thich is used to bread the bonding between obervable and observer.
// Operators: Something which is used to modify the data   .... obervable before it reach the observer.

// I can introduce an operator between ....
// Operator will change/modify data before it reach the observer.

class MainActivity : AppCompatActivity() {
    var disposable : Disposable?= null

    override fun onCreate(savedInstanceState: Bundle?) {




        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//RetrofitClient().userAccess()
        var userResponse = RetrofitClient().userAccess()




        var x = getObservable().subscribeOn(Schedulers.io())
                .filter{
                    it.startsWith("T")
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver())

//
//        getObservable().subscribeOn(Schedulers.computation())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeWith(getObserver())




    }

    fun getObservable(): Observable<String> {
        return Observable.just("One", "Two", "Three", "Four", "Five","Six","Seven", "Eight")
    }



    fun getObserver2():SingleObserver<PostResponse>{

        return object :SingleObserver<PostResponse>{
            override fun onSubscribe(d: Disposable) {

                disposable = d

            }

            override fun onSuccess(t: PostResponse) {
                //TODO("Not yet implemented")

                Log.d("abc","THIS: "+t.toString())
            }

            override fun onError(e: Throwable) {
               // TODO("Not yet implemented")
            }


        }

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()

    }


    fun getObserver(): Observer<String> {


        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.d("abc", "onSubscribe")

            }

            override fun onNext(t: String) {
                Log.d("abc", "$t + onNext")

            }

            override fun onError(e: Throwable) {
                Log.d("abc", "onError")

            }

            override fun onComplete() {
                Log.d("abc", "onComplete")

            }

        }

    }
}