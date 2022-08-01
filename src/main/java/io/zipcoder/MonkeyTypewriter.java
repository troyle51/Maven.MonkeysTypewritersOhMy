package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
        SafeCopier safeCopier = new SafeCopier(introduction);

        Thread unsafeCopier1 = new Thread(unsafeCopier);
        Thread unsafeCopier2 = new Thread(unsafeCopier);
        Thread unsafeCopier3 = new Thread(unsafeCopier);
        Thread unsafeCopier4 = new Thread(unsafeCopier);
        Thread unsafeCopier5 = new Thread(unsafeCopier);
        unsafeCopier1.start();
        unsafeCopier2.start();
        unsafeCopier3.start();
        unsafeCopier4.start();
        unsafeCopier5.start();

        Thread safeCopier1 = new Thread(safeCopier);
        Thread safeCopier2 = new Thread(safeCopier);
        Thread safeCopier3 = new Thread(safeCopier);
        Thread safeCopier4 = new Thread(safeCopier);
        Thread safeCopier5 = new Thread(safeCopier);



        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        unsafeCopier1.run();
        unsafeCopier2.run();
        unsafeCopier3.run();
        unsafeCopier4.run();
        unsafeCopier5.run();

        System.out.println("\n");

        safeCopier1.run();
        safeCopier2.run();
        safeCopier3.run();
        safeCopier4.run();
        safeCopier5.run();
    }
}