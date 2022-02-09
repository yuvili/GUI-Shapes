# GUI Shapes
This program is a collection of basic shape implementations writen in java.

## Geometry
This packege contains the main implementations of 2D shapes - Point, Circle, Segment, Triangle and Rectengle.
Each shape has a basic OOP functions such as copy, move and toString. In shapes like Circle, Triangle and Rectengle the shape's area and perimeter can be calculated.

## GUI_Shape
This class represents a GUI shape with meta data of color, fill/empty and tag, and contains a geometric shape (GeoShape).
This method returns the GeoShape from which this GUI_Shape is composed from.
- *getShape()* : This method returns the GeoShape that this GUI_Shape is composed from. 
- *setShape(GeoShape g)* : This method sets the GeoShape to g.
- *isFilled()* : This method return the isFill value: true iff the shape is fill.
- *setFilled(boolean filled)* : This method sets the fill value of this shape.
- *getColor()* : This method returns the Color of this shape.
- *setColor(Color cl)* : This method sets the new Color of this shape.
- *getTag()* : This method returns the tag value (int value).
- *setTag(int tag)* : This method sets the tag value of this shape.
- *copy()* : This method compute a new (deep) copy of this shape.
- *toString()* : This method returns a String representation of this Shape.

## Shape_Collection
This class represents a Comparator over GUI_Shapes as a linear order over GUI_Shapes.

- *get(int i)* : This method return a reference (not a copy) to the i'th element in the collection.
- *size()* : returns the size of the collection (if empty returns 0).
- *removeElementAt(int i)* : This method remove (and return) the gui_shape at the i'th location. After removing, the size of this collection decreases by 1 
and the order of the elements remains the same - just with out the removed element.
- *add(GUI_Shape s)* : This method adds the gui_element s to this collection in the last position.
- *addAt(GUI_Shape s, int i)* : This method adds the gui_element s to this collection in the i'th position.
- *copy()* : This method constructs a deep copy of this collection.
- *sort(Comparator<GUI_Shape> comp)* : This method sorts this gui_shape collection according to the comp Comparator - in increasing order.
- *removeAll()* : This method simple removes all the elements from this collection.
- *save(String file_name)* : This method saves this gui_shape collection to a text file.
- *load(String file)* : This method restore a gui_shape collection from text file (as saved be the save method).
- *getBoundingBox()* : This methods returns the minimal bounding box containing all the shapes in this collection.

## Ex4
This method inits the GUI_Shape_Collection.

- *init(GUI_Shape_Collection g)* : This method inits the GUI_Shape_Collection.
- *getShape_Collection()* : This method returns a link to the GUI_Shape_Collection
- *show()* : This method presents the GUI shapes in this collection in a GUI window.
- *getInfo()* : This method returns a String containing all the "toString" of each GUI_shape in the collection.

