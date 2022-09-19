package com.tim.geometry;

import com.tim.geometry.rectangle.Point;
import com.tim.geometry.rectangle.Rectangle;
import com.tim.geometry.rectangle.RectangleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GeometryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GeometryApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if (args.length > 0) {
			List<String> stringArgs = new ArrayList<>();

			for (String arg : args) {
				stringArgs.addAll(Arrays.asList(arg.split(",")));
			}

			Rectangle rec1 = new Rectangle(
					stringArgs.get(0),
					stringArgs.get(1),
					stringArgs.get(2),
					stringArgs.get(3)
			);

			Rectangle rec2 = new Rectangle(
					stringArgs.get(4),
					stringArgs.get(5),
					stringArgs.get(6),
					stringArgs.get(7)
			);

			System.out.println("\n" + "Rectangle 1:" + "\n" + rec1);
			System.out.println("\n" + "Rectangle 2:" + "\n" + rec2);

			System.out.println("\n" + "Analysis:");
			List<Point> commonSides = RectangleService.intersections(rec1,rec2);
			System.out.println("intersections: " + Arrays.toString(commonSides.toArray()));
			System.out.println("contained: " + RectangleService.contained(rec1,rec2));
			System.out.println("adjacent: " + RectangleService.adjacency(rec1,rec2));
		}
	}
}
