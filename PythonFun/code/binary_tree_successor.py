class BinaryTree:
    def __init__(self, value, left=None, right=None, parent=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent

def findSuccessor(tree, node):
    if node.right is not None:
        return getLeftMostChild(node.right)
    return getRightMostParent(node)

def getLeftMostChild(node):
    while node.left is not None:
        node = node.left
    return node

def getRightMostParent(node):
    while node.parent is not None and node.parent.right == node:
        node = node.parent
    return node.parent
