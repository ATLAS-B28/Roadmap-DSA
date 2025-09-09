#square area
def sqr_area(l):
    return l * l
#reactangle
def ret_area(l, b):
    return l * b
def circle_area(radius):
    return 3.14 * (radius ** 2)
shape_dict = {
    'square': sqr_area,
    'rectangle': ret_area,
    'circle': circle_area
}
def diameter(radius):
    return 2 * radius
def circumference(radius):
    return 2 * 3.14 * radius