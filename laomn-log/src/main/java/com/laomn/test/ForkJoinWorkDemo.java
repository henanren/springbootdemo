// package com.laomn.test;
//
// import java.util.concurrent.ForkJoinPool;
// import java.util.concurrent.ForkJoinTask;
// import java.util.stream.LongStream;
//
// import org.junit.Test;
//
//
//
//
//
// public class ForkJoinWorkDemo {
//
// // test invoke = -5340232216128654848 time: 42278
// // test2 invoke = -5340232216128654848 time: 71298
// // test3 invoke = -5340232216128654848 time: 2669
//
// @Test
// public void test() {
// long l = System.currentTimeMillis();
// ForkJoinPool forkJoinPool = new ForkJoinPool();// 实现ForkJoin
// // 就必须有ForkJoinPool的支持
// ForkJoinTask<Long> task = new ForkJoinWork(0L, 10000000000L);// 参数为起始值与结束值
// Long invoke = forkJoinPool.invoke(task);
// long l1 = System.currentTimeMillis();
// System.out.println("test invoke = " + invoke + " time: " + (l1 - l));
// // invoke = -5340232216128654848 time: 76474
// }
//
// @Test
// public void test2() {
// Long x = 0L;
// Long y = 10000000000L;
// long l = System.currentTimeMillis();
// for (Long i = 0L; i <= y; i++) {
// x += i;
// }
// long l1 = System.currentTimeMillis();
// System.out.println("test2 invoke = " + x + " time: " + (l1 - l));
// // invoke = -5340232216128654848 time: 160939
// }
//
// @Test
// public void test3() {
// long l = System.currentTimeMillis();
// long reduce = LongStream.rangeClosed(0, 10000000000L).parallel().reduce(0,
// Long::sum);
// long l1 = System.currentTimeMillis();
// System.out.println("test3 invoke = " + reduce + " time: " + (l1 - l));
// // invoke = -5340232216128654848 time: 15531
// }
// }