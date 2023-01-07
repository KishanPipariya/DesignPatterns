
class Shape:

    def __init__(self):
        pass
    
    def message(self):
        print("Shape")

class Circle(Shape):

    def __init__(self):
        pass
    

class Square:

    def __init__(self):
        pass
    
    def message(self):
        print("Square") 

def ShapeFactory(shape):
    shapes = {
        'Circle': Circle,
        'Square': Square
    }
    return shapes[shape]()


a = ShapeFactory('Circle')
a.message()
    