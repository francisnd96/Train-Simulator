/**
 * Train by Francis Nana-Dabankah
 * 
 * This 3D environment consists of 
 * A moving train with rotating wheels 
 * A track 
 * A rotating textured sun (with lights) 
 * A small house with my own shape (and lights)
 * A grass/sky image background 
 * 
 * With the mouseWheel you can zoom in and out
 * With the right click on the mouse you can move around the enviromment
 * You cannot rotate the enviroment
 *
 */

import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;
import com.sun.j3d.utils.behaviors.mouse.*;
import javax.swing.JFrame;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.GeometryInfo;
import com.sun.j3d.utils.geometry.NormalGenerator;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.geometry.Box;

public class Example3D extends JFrame {

	public BranchGroup createSceneGraph() {

		// creating the bounds of the universe
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);

		// creating a single branch group
		BranchGroup objRoot = new BranchGroup();

		// creating the main transform group
		TransformGroup mainTG = new TransformGroup();
		mainTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		mainTG.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		// green colour
		Appearance greenApp = new Appearance();
		Color3f greenColor = new Color3f(0.0f, 1.0f, 0.0f);
		ColoringAttributes greenCA = new ColoringAttributes();
		greenCA.setColor(greenColor);
		greenApp.setColoringAttributes(greenCA);

		// blue colour
		Appearance blueApp = new Appearance();
		Color3f blueColor = new Color3f(0, 0, 139);
		ColoringAttributes blueCA = new ColoringAttributes();
		blueCA.setColor(blueColor);
		blueApp.setColoringAttributes(blueCA);

		// brown colour
		Appearance brownApp = new Appearance();
		Color3f brownColor = new Color3f(255, 248, 220);
		ColoringAttributes brownCA = new ColoringAttributes();
		brownCA.setColor(brownColor);
		brownApp.setColoringAttributes(brownCA);

		// red colour
		Appearance redApp = new Appearance();
		Color3f redColor = new Color3f(255, 0, 0);
		ColoringAttributes redCA = new ColoringAttributes();
		redCA.setColor(redColor);
		redApp.setColoringAttributes(redCA);

		// yellow colour
		Appearance yellowApp = new Appearance();
		Color3f yellowColor = new Color3f(255, 255, 0);
		ColoringAttributes yellowCA = new ColoringAttributes();
		yellowCA.setColor(yellowColor);
		yellowApp.setColoringAttributes(yellowCA);

		// create & translate shape
		Box driverBox = new Box(1f, 1.6f, 1f, greenApp);
		TransformGroup driverBoxtg = translate(driverBox, new Vector3f(-1.8f, 0f, 0.0f));

		// create & translate shape
		Box frontBox = new Box(1.4f, 1f, 1f, blueApp);
		TransformGroup frontBoxtg = translate(frontBox, new Vector3f(.65f, -.6f, 0.0f));

		// create & translate shape
		Cone frontCone = new Cone(1f, 1f, greenApp);
		TransformGroup frontConetg1 = new TransformGroup();
		frontConetg1.addChild(frontCone);
		Transform3D rotation = new Transform3D();
		Transform3D temp = new Transform3D();
		rotation.rotX(Math.PI);
		temp.rotZ(Math.PI / -2);
		rotation.mul(temp);
		frontConetg1.setTransform(rotation);
		TransformGroup frontConetg = translate(frontConetg1, new Vector3f(2.6f, -.6f, 0.0f));

		// create & translate shape
		Box window1 = new Box(.5f, .5f, .03f, yellowApp);
		TransformGroup window1tg = translate(window1, new Vector3f(-1.8f, .6f, 1f));

		// create & translate shape
		Box window2 = new Box(.5f, .5f, .03f, yellowApp);
		TransformGroup window2tg = translate(window2, new Vector3f(-1.8f, .6f, -1f));

		// create & translate shape
		Box wheelBar1 = new Box(2.1f, .1f, .1f, yellowApp);
		TransformGroup wheelBartg1 = translate(wheelBar1, new Vector3f(-0.3f, -1.9f, 1.5f));

		// create & translate shape
		Box wheelBar2 = new Box(2.1f, .1f, .1f, yellowApp);
		TransformGroup wheelBartg2 = translate(wheelBar2, new Vector3f(-0.3f, -1.9f, -1.5f));

		// create & translate shape
		Box track = new Box(13f, 0.3f, 1.7f, blueApp);
		TransformGroup tracktg = translate(track, new Vector3f(10f, -3.8f, 0f));
		// add track to transform group
		mainTG.addChild(tracktg);

		// create & translate shape
		Box post = new Box(.2f, .4f, .2f, greenApp);
		TransformGroup posttg = translate(post, new Vector3f(1f, .7f, 0f));

		// create, translate the add railing
		Box rail1 = new Box(.5f, .2f, 1.7f, greenApp);
		TransformGroup rail1tg = translate(rail1, new Vector3f(-1f, -3.3f, 0f));
		mainTG.addChild(rail1tg);
		Box rail2 = new Box(.5f, .2f, 1.7f, greenApp);
		TransformGroup rail2tg = translate(rail2, new Vector3f(2f, -3.3f, 0f));
		mainTG.addChild(rail2tg);
		Box rail3 = new Box(.5f, .2f, 1.7f, greenApp);
		TransformGroup rail3tg = translate(rail3, new Vector3f(5f, -3.3f, 0f));
		mainTG.addChild(rail3tg);
		Box rail4 = new Box(.5f, .2f, 1.7f, greenApp);
		TransformGroup rail4tg = translate(rail4, new Vector3f(8f, -3.3f, 0f));
		mainTG.addChild(rail4tg);
		Box rail5 = new Box(.5f, .2f, 1.7f, greenApp);
		TransformGroup rail5tg = translate(rail5, new Vector3f(11f, -3.3f, 0f));
		mainTG.addChild(rail5tg);
		Box rail6 = new Box(.5f, .2f, 1.7f, greenApp);
		TransformGroup rail6tg = translate(rail6, new Vector3f(14f, -3.3f, 0f));
		mainTG.addChild(rail6tg);
		Box rail7 = new Box(.5f, .2f, 1.7f, greenApp);
		TransformGroup rail7tg = translate(rail7, new Vector3f(17f, -3.3f, 0f));
		mainTG.addChild(rail7tg);
		Box rail8 = new Box(.5f, .2f, 1.7f, greenApp);
		TransformGroup rail8tg = translate(rail8, new Vector3f(20f, -3.3f, 0f));
		mainTG.addChild(rail8tg);

		// create & translate shape
		Cone chimneyCone = new Cone(.5f, .5f, redApp);
		TransformGroup chimneyConetg = new TransformGroup();
		chimneyConetg.addChild(chimneyCone);
		Transform3D rotation3 = new Transform3D();
		Transform3D temp3 = new Transform3D();
		rotation3.rotX(Math.PI / 90);
		rotation3.mul(temp3);
		chimneyConetg.setTransform(rotation3);
		TransformGroup chimneyConetg1 = translate(chimneyConetg, new Vector3f(1f, 1.3f, 0f));

		// create colours for sun material
		Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
		Color3f red = new Color3f(0.7f, .15f, .15f);

		TransformGroup sunRotate = new TransformGroup();

		// load image with texture loader, luminance makes the image black and
		// white
		TextureLoader loader = new TextureLoader("/s_home/fnd1/workspace/Java3D/sun.jpg", "LUMINANCE", new Container());
		Texture texture = loader.getTexture();
		texture.setBoundaryModeS(Texture.WRAP);
		texture.setBoundaryModeT(Texture.WRAP);
		texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.0f, 0.0f));

		TextureAttributes texAttr = new TextureAttributes();
		texAttr.setTextureMode(TextureAttributes.MODULATE);
		Appearance ap = new Appearance();
		ap.setTexture(texture);
		ap.setTextureAttributes(texAttr);

		ap.setMaterial(new Material(red, black, red, black, 1.0f));

		// the primitives enable texturing
		Sphere sphere = new Sphere(2.5f, Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS, ap);
		sunRotate.addChild(sphere);

		// create light
		Color3f light1Color = new Color3f(1f, 4f, 1f);
		BoundingSphere bounds4 = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);

		// add directional light
		Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
		DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
		light1.setInfluencingBounds(bounds4);
		sunRotate.addChild(light1);

		// add ambient light
		AmbientLight ambientLight = new AmbientLight(new Color3f(.5f, .5f, .5f));
		ambientLight.setInfluencingBounds(bounds4);
		sunRotate.addChild(ambientLight);

		// make sun rotate
		sunRotate = rotate(sunRotate, new Alpha(400, 5000));
		TransformGroup suntg = translate(sunRotate, new Vector3f(3f, 8f, 0.0f));
		mainTG.addChild(suntg);

		// create wheels
		Cylinder c = new Cylinder(1, .3f, 1, ap);
		Cylinder c2 = new Cylinder(1, .3f, 1, ap);
		Cylinder c3 = new Cylinder(.7f, .3f, 1, ap);
		Cylinder c4 = new Cylinder(.7f, .3f, 1, ap);
		Cylinder c5 = new Cylinder(.7f, .3f, 1, ap);
		Cylinder c6 = new Cylinder(.7f, .3f, 1, ap);

		// translation & rotation of wheels
		Transform3D transform = new Transform3D();
		Transform3D translate1 = new Transform3D();
		translate1.setTranslation(new Vector3d(0.0, 4, 0.0));
		transform.mul(translate1, transform);
		Transform3D rotate = new Transform3D();
		rotate.rotX(Math.PI);

		TransformGroup object = new TransformGroup(rotate);
		object.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		Alpha alpha = new Alpha(400, 5000);
		RotationInterpolator interpolator = new RotationInterpolator(alpha, object);

		interpolator.setSchedulingBounds(new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1.0));

		object.addChild(interpolator);
		object.addChild(c);

		TransformGroup adjustWheel = new TransformGroup();
		TransformGroup adjustWheel2 = new TransformGroup();
		adjustWheel.addChild(object);
		Transform3D rotation2 = new Transform3D();
		Transform3D temp2 = new Transform3D();

		rotation2.rotX(Math.PI / 2);
		temp2.rotZ(Math.PI);
		rotation2.mul(temp2);
		adjustWheel.setTransform(rotation2);
		adjustWheel2.setTransform(rotation2);
		TransformGroup wheelLocation = translate(adjustWheel, new Vector3f(-1.8f, -1.7f, -1.2f));

		// add 2nd wheel
		TransformGroup mytg = adjustWheels(c2, new Vector3f(-1.8f, -3f, -1.2f));
		mytg.setTransform(flipUp());
		TransformGroup h = translate(mytg, new Vector3f(-1.8f, -1.7f, 1.2f));

		// add 3rd wheel
		TransformGroup mytg2 = adjustWheels(c3, new Vector3f(3f, 3f, -3f));
		mytg2.setTransform(flipUp());
		TransformGroup h2 = translate(mytg2, new Vector3f(0f, -2.0f, 1.2f));

		// add 4th wheel
		TransformGroup mytg3 = adjustWheels(c4, new Vector3f(3f, 3f, -3f));
		mytg3.setTransform(flipUp());
		TransformGroup h3 = translate(mytg3, new Vector3f(1.5f, -2.0f, 1.2f));

		// add 5th wheel
		TransformGroup mytg4 = adjustWheels(c5, new Vector3f(3f, 3f, -3f));
		mytg4.setTransform(flipUp());
		TransformGroup h4 = translate(mytg4, new Vector3f(0f, -2.0f, -1.2f));

		// add 6th wheel
		TransformGroup mytg5 = adjustWheels(c6, new Vector3f(3f, 3f, -3f));
		mytg5.setTransform(flipUp());
		TransformGroup h5 = translate(mytg5, new Vector3f(1.5f, -2.0f, -1.2f));

		// make edge relations between the scene graph nodes
		// cube c is scaled by 2 and THEN moved -5 along z axis (by cubeTG)
		// cube c2 and box b at the origin
		objRoot.addChild(mainTG);

		// put all train objects into one group
		TransformGroup train = new TransformGroup();
		train.addChild(driverBoxtg);
		train.addChild(frontBoxtg);
		train.addChild(frontConetg);
		train.addChild(window1tg);
		train.addChild(window2tg);
		train.addChild(wheelBartg1);
		train.addChild(wheelBartg2);
		train.addChild(posttg);
		train.addChild(chimneyConetg1);
		train.addChild(wheelLocation);
		train.addChild(h);
		train.addChild(h2);
		train.addChild(h3);
		train.addChild(h4);
		train.addChild(h5);

		TransformGroup movement = new TransformGroup();
		movement.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		// interpolator for moving the train.
		PositionInterpolator mInterpolator = new PositionInterpolator(new Alpha(100, 3000), movement, new Transform3D(),
				0f, 20f);

		// Establish the animation region for this
		// interpolator.
		mInterpolator.setSchedulingBounds(new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1.0));

		// Populate the transform group.
		movement.addChild(mInterpolator);
		movement.addChild(train);

		mainTG.addChild(movement);

		// collision

		// create & translate wall
		Box wall = new Box(.5f, 3f, 3f, brownApp);
		TransformGroup walltg = translate(wall, new Vector3f(14f, 0f, 0f));

		// create & translate red wall
		Box redWall = new Box(.5f, 3f, 3f, redApp);
		TransformGroup redWalltg = translate(redWall, new Vector3f(14f, 0f, 0f));

		// create & translate yellow wall
		Box yellowWall = new Box(.5f, 3f, 3f, yellowApp);
		TransformGroup yellowWalltg = translate(yellowWall, new Vector3f(14f, 0f, 0f));

		Switch colourSwitch = new Switch();
		
		// allow ability to switch between colours
		colourSwitch.setCapability(Switch.ALLOW_SWITCH_WRITE);
		colourSwitch.addChild(walltg); // child 0
		colourSwitch.addChild(redWalltg); // child 1
		colourSwitch.addChild(yellowWalltg); // child 1

		// initial colour of wall
		colourSwitch.setWhichChild(0);

		Transform3D walls = new Transform3D();
		walls.setTranslation(new Vector3f(0.7f, 0.0f, 0.0f));
		TransformGroup wallGroup = new TransformGroup(walls);
		wallGroup.addChild(colourSwitch);
		mainTG.addChild(wallGroup);

		movement.setCollisionBounds(new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 0.9f));
		// Enabled for collision purposes
		movement.setCollidable(true);

		// Enabled for collision purposes
		colourSwitch.setCollidable(true);

		CollisionBehaviour colBehaviour = new CollisionBehaviour(movement, colourSwitch, bounds);
		mainTG.addChild(colBehaviour);

		// add background
		flatImageBackground(mainTG);

		// My own shape
		Point3f e = new Point3f(1.0f, 0.0f, 0.0f); // east
		Point3f s = new Point3f(0.0f, 0.0f, 1.0f); // south
		Point3f w = new Point3f(-1.0f, 0.0f, 0.0f); // west
		Point3f n = new Point3f(0.0f, 0.0f, -1.0f); // north
		Point3f t = new Point3f(0.0f, 1.721f, 0.0f); // top

		TriangleArray myRoof = new TriangleArray(9, TriangleArray.COORDINATES);
		myRoof.setCoordinate(0, e);
		myRoof.setCoordinate(1, t);
		myRoof.setCoordinate(2, s);
		myRoof.setCoordinate(3, s);
		myRoof.setCoordinate(4, t);
		myRoof.setCoordinate(5, w);
		myRoof.setCoordinate(6, w);
		myRoof.setCoordinate(7, t);
		myRoof.setCoordinate(8, n);

		GeometryInfo geometryInfo = new GeometryInfo(myRoof);
		NormalGenerator ng = new NormalGenerator();
		ng.generateNormals(geometryInfo);
		GeometryArray result = geometryInfo.getGeometryArray();

		// houseroof appearance
		Appearance roofApp = new Appearance();
		roofApp.setMaterial(new Material(red, black, red, black, 1.0f));

		Shape3D shape = new Shape3D(result, roofApp);
		Color3f roofCol = new Color3f(1f, 4f, 1f);
		BoundingSphere roofBounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);

		// add directional light
		Vector3f roofLight = new Vector3f(4.0f, -7.0f, -12.0f);
		DirectionalLight dirRoofLight = new DirectionalLight(roofCol, roofLight);
		dirRoofLight.setInfluencingBounds(roofBounds);

		TransformGroup h6 = translate(shape, new Vector3f(7f, -1.1f, -2f));
		h6.addChild(dirRoofLight);
		mainTG.addChild(h6);

		Box house = new Box(.5f, .7f, 1f, redApp);
		TransformGroup housetg = translate(house, new Vector3f(7f, -1.8f, -2.0f));
		mainTG.addChild(housetg);

		// Create the zoom behavior node
		MouseZoom behavior2 = new MouseZoom();
		behavior2.setTransformGroup(mainTG);
		objRoot.addChild(behavior2);
		behavior2.setSchedulingBounds(bounds);

		// Create wheelzoom behaviour
		MouseWheelZoom mouseWheelZoom = new MouseWheelZoom();
		mouseWheelZoom.setFactor(1);
		mouseWheelZoom.setTransformGroup(mainTG);
		objRoot.addChild(mouseWheelZoom);
		mouseWheelZoom.setSchedulingBounds(bounds);
		
		MouseRotate behavior = new MouseRotate();
		behavior.setTransformGroup(mainTG);
		objRoot.addChild(behavior);
		behavior.setSchedulingBounds(bounds);

		// Create the translate behavior node
		MouseTranslate behavior3 = new MouseTranslate();
		behavior3.setTransformGroup(mainTG);
		objRoot.addChild(behavior3);
		behavior3.setSchedulingBounds(bounds);

		objRoot.compile();
		return objRoot;
	}

	// create a "standard" universe using SimpleUniverse
	public Example3D() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		Canvas3D c = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
		cp.add("Center", c);
		BranchGroup scene = createSceneGraph();
		SimpleUniverse u = new SimpleUniverse(c);
		u.getViewingPlatform().setNominalViewingTransform();
		u.addBranchGraph(scene);

		// *** create a viewing platform
		TransformGroup cameraTG = u.getViewingPlatform().getViewPlatformTransform();
		// starting postion of the viewing platform
		Vector3f translate = new Vector3f();
		Transform3D T3D = new Transform3D();
		// move along z axis by 10.0f ("move away from the screen")
		translate.set(10.0f, 0.0f, 30.0f);
		T3D.setTranslation(translate);
		cameraTG.setTransform(T3D);
		setTitle("Francis' (fnd1) Train");
		setSize(512, 512);
		setVisible(true);
	}

	public static TransformGroup translate(Node node, Vector3f vector) {

		Transform3D transform3D = new Transform3D();
		transform3D.setTranslation(vector);
		TransformGroup transformGroup = new TransformGroup();
		transformGroup.setTransform(transform3D);

		transformGroup.addChild(node);
		return transformGroup;
	}

	TransformGroup rotate(Node node, Alpha alpha) {

		TransformGroup tGroup = new TransformGroup();
		tGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		// Create an interpolator for rotating the node.
		RotationInterpolator interpolator = new RotationInterpolator(alpha, tGroup);

		// Establish the animation region for this
		// interpolator.
		interpolator.setSchedulingBounds(new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1.0));

		// Populate the xform group.
		tGroup.addChild(interpolator);
		tGroup.addChild(node);

		return tGroup;

	}

	// method to rotate and position wheels
	TransformGroup adjustWheels(Node node, Vector3f vector) {
		TransformGroup adjustWheel = new TransformGroup();
		adjustWheel.addChild(node);
		adjustWheel = rotate(adjustWheel, new Alpha(400, 5000));
		Transform3D rotation2 = new Transform3D();
		Transform3D temp2 = new Transform3D();

		rotation2.rotX(Math.PI / 2);
		temp2.rotZ(Math.PI);
		rotation2.mul(temp2);
		adjustWheel.setTransform(rotation2);
		TransformGroup wheelLocation = translate(adjustWheel, vector);

		return wheelLocation;
	}

	// the wheels initially lie horizontal, this makes them stand vertical
	Transform3D flipUp() {
		Transform3D rotation = new Transform3D();
		Transform3D temp = new Transform3D();

		rotation.rotX(Math.PI / 2);
		temp.rotZ(Math.PI);
		rotation.mul(temp);
		return rotation;
	}

	// applies background
	public void flatImageBackground(TransformGroup background) {
		Background myBackground = new Background();
		myBackground.setImage(new TextureLoader("/s_home/fnd1/workspace/Java3D/landscape.jpeg", this).getImage());
		myBackground.setImageScaleMode(Background.SCALE_FIT_ALL);
		myBackground.setApplicationBounds(new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 2000.0));
		background.addChild(myBackground);
	}

	public static void main(String[] args) {

		Example3D train = new Example3D();

	}

}
