package com.tim.geometry;

import com.tim.geometry.rectangle.Point;
import com.tim.geometry.rectangle.Rectangle;
import com.tim.geometry.rectangle.RectangleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GeometryApplicationTests {

	@Test
	void separatedRectangles() {
		Rectangle rec1 = new Rectangle("1","5","3","2");
		Rectangle rec2 = new Rectangle("4","6","5","4");

		assertThat(RectangleService.adjacency(rec1,rec2)).isEqualTo(false);
		assertThat(RectangleService.intersections(rec1,rec2)).isEqualTo(Collections.emptyList());
		assertThat(RectangleService.contained(rec1,rec2)).isEqualTo(false);
	}

	@Test
	void adjacentRectangles() {
		Rectangle rec1 = new Rectangle("1","5","3","2");
		Rectangle rec2 = new Rectangle("3","6","5","1");

		assertThat(RectangleService.adjacency(rec1,rec2)).isEqualTo(true);
		assertThat(RectangleService.intersections(rec1,rec2)).isEqualTo(Collections.emptyList());
		assertThat(RectangleService.contained(rec1,rec2)).isEqualTo(false);
	}

	@Test
	void containedRectangle() {
		Rectangle rec1 = new Rectangle("1","5","4","2");
		Rectangle rec2 = new Rectangle("2","4","3","2");

		assertThat(RectangleService.adjacency(rec1,rec2)).isEqualTo(false);
		assertThat(RectangleService.intersections(rec1,rec2)).isEqualTo(Collections.emptyList());
		assertThat(RectangleService.contained(rec1,rec2)).isEqualTo(true);
	}

	@Test
	void intersectingRectangles() {
		Rectangle rec1 = new Rectangle("1","5","4","2");
		Rectangle rec2 = new Rectangle("3","6","5","3");
		List<Point> intersections = List.of(new Point(3,5), new Point(4,3));

		assertThat(RectangleService.adjacency(rec1,rec2)).isEqualTo(false);
		assertThat(RectangleService.intersections(rec1,rec2)).isEqualTo(intersections);
		assertThat(RectangleService.contained(rec1,rec2)).isEqualTo(false);
	}

	@Test
	void largeIntersectingRectangles() {
		Rectangle rec1 = new Rectangle("1","5000","400","200");
		Rectangle rec2 = new Rectangle("300","6000","500","300");
		List<Point> intersections = List.of(new Point(300,5000), new Point(400,300));

		assertThat(RectangleService.adjacency(rec1,rec2)).isEqualTo(false);
		assertThat(RectangleService.intersections(rec1,rec2)).isEqualTo(intersections);
		assertThat(RectangleService.contained(rec1,rec2)).isEqualTo(false);
	}
}
