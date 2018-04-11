package com.example.edNgulele.MavenProject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        Observable.just("Hello GDG Maputo")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("OnSubscribe: " + Thread.currentThread().getName());


                    }

                    @Override
                    public void onNext(String s) {

                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("Ups: " + e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Terminado");


                    }
                });

        Observable.just(3, 6, 9)
                .map(x -> 10 * x)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("Map: " + integer);

                    }
                });
        Observable.just(3, 6, 9)
                .map(x -> 10 * x)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("Map: " + integer);

                    }
                });

        System.out.println("Map Testing");


        Observable.just("Hello GDG Maputo")
                .map(s -> s.split(" "))
                .subscribe(new Consumer<String[]>() {
                    @Override
                    public void accept(String[] strings) throws Exception {
                        System.out.println(strings);

                    }
                }).toString();

        System.out.println("FlatMap Testing");

        Observable.just("Hello GDG Maputo")
                .flatMap(s -> Observable.fromArray(s.split(" ")))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);

                    }
                });

        System.out.println("Filter");

        Observable.just(2, 30, 22, 5, 60, 1)
                .filter(x -> x > 10)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });

        System.out.println("Distinct");

        Observable.just(1, 1, 2, 1, 3)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });

        System.out.println("Skip");

        Observable.just(1, 2, 3, 4)
                .skip(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });


        System.out.println("Merge");

        Observable<String> set1 = Observable.just("MozDevz", "Muthiana Code", "somthing else");
        Observable<String> set2 = Observable.just("GDG Maputo", "Women Techmakers");

        Observable.merge(set1, set2)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });



        System.out.println("Zip");

        Observable.zip(set1,set2, (str1, str2)-> str1 + " - " + str2)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
    }


}
