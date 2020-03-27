package com.framework.hanason;

import com.framework.hanason.common.random.IdGenerator;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author sorata 2020-03-25 15:12
 */
@State(Scope.Benchmark)
@Warmup(iterations = 3,time = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@Measurement(iterations = 5)
@Fork(1)
public class ThreadRandomTest {


    public static void main(String[] args) {
        Options build = new OptionsBuilder().include(ThreadRandomTest.class.getName()).build();
        try {
            new Runner(build).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }


    @Benchmark
    @Threads(5)
    public void randStr(){
        IdGenerator.randStr(50);
    }


    @Benchmark
    @Threads(5)
    public void randStr2(){
        IdGenerator.randStr2(50);
    }


}
