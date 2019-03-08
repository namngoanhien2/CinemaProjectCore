package main;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import controller.*;
//import controller.LoginController;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class JavaApplication {
    public static HttpExchange he;
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpServer server = HttpServer.create(new InetSocketAddress(9998), 0);
        server.createContext("/login", new LoginController());
        server.createContext("/findAll", new FindAllController());
        server.createContext("/findByName", new FindByNameController());
        server.createContext("/register", new RegisterController());
        server.createContext("/findMovie", new MovieFindAllController());
        server.createContext("/findByNameMovie", new MovieFindByNameController());
        server.createContext("/findSeatByShowTimeId", new SeatFindByShowTimeController());
        server.createContext("/updateMovie", new MovieUpdateController());
        server.createContext("/bookTicketByCinema", new BookingTicketByCinemaController());
        server.createContext("/bookTicketByMovie", new BookingTicketByMovieController());
        server.createContext("/findMovieById", new MovieFindByIdController());

        System.out.println("Start Port: " + server.getAddress());
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();

    }
}
