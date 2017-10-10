# test_queue.py

import datastructures

def main():
    print('This program tests the Queue class.\n')

    print('Adding 1, 2, 3, 4, 5, 2  to queue1...')
    queue1 = datastructures.Queue()
    queue1.enqueue(1)
    queue1.enqueue(2)
    queue1.enqueue(3)
    queue1.enqueue(4)
    queue1.enqueue(5)
    queue1.enqueue(2)

    print('\nqueue1 should contain 1, 2, 3, 4, 5, 2.')
    print('queue1 contains the following from front to back:')
    print(queue1)

    print('The first element in queue1 should be 1.') 
    item = queue1.first()
    if item == 1:
        print('Correct: The first element is 1.')
    else:
        print('ERROR: The first element is %d.\n' % item)
    if queue1.size() == 6:
        print('Correct: The size is 6.')
    else:
        print('ERROR: The size is %d instead of 6.' % queue1.size())
    if not queue1.is_empty():
        print('Correct: The queue is not empty.')
    else:
        print('ERROR: The queue should not be empty.')

    print('\nRemoving 1 from queue1...')
    item = queue1.dequeue()
    first_item = queue1.first()
    if item == 1 and first_item == 2:
        print('Correct: Removed 1 from queue1 and first is now 2')
    else:
        print('ERROR: Removed %d from queue1 and first is %d.' \
             % (item, first_item))
    if queue1.size() == 5:
        print('Correct: The size is 5.')
    else:
        print('ERROR: The size is %d instead of 5.' % queue1.size())
    if not queue1.is_empty():
        print('Correct: The queue is not empty.')
    else:
        print('ERROR: The queue should not be empty.')

    print('\nRemoving 2 from queue1...')
    item = queue1.dequeue()
    first_item = queue1.first()
    if item == 2 and first_item == 3:
        print('Correct: Removed 2 from queue1 and first is now 3')
    else:
        print('ERROR: Removed %d from queue1 and first is %d.' \
             % (item, first_item))
    if queue1.size() == 4:
        print('Correct: The size is 4.')
    else:
        print('ERROR: The size is %d instead of 4.' % queue1.size())
    if not queue1.is_empty():
        print('Correct: The queue is not empty.')
    else:
        print('ERROR: The queue should not be empty.')

    print('\nqueue1 should contain 3, 4, 5, 2.')
    print('queue1 contains the following from front to back:')
    print(queue1)

    print('Adding 6 to the queue...')
    queue1.enqueue(6)

    print('Adding 7 to the queue...')
    queue1.enqueue(7)

    print('\nqueue1 should now contain 3, 4, 5, 2, 6, 7.')
    print('queue1 contains the following from front to back:')
    print(queue1)

    print('Removing 3 from queue1...')
    item = queue1.dequeue()
    first_item = queue1.first()
    if item == 3 and first_item == 4:
        print('Correct: Removed 3 from queue1 and first is now 4')
    else:
        print('ERROR: Removed %d from queue1 and first is %d.' \
             % (item, first_item))

    print('\nRemoving 4 from queue1...')
    item = queue1.dequeue()
    first_item = queue1.first()
    if item == 4 and first_item == 5:
        print('Correct: Removed 4 from queue1 and first is now 5')
    else:
        print('ERROR: Removed %d from queue1 and first is %d.' \
             % (item, first_item))

    print('\nqueue1 should now contain 5, 2, 6, 7.')
    print('queue1 contains the following from front to back:')
    print(queue1)

    print('Testing an empty queue...\n')

    queue2 = datastructures.Queue()
    if queue2.size() == 0:
        print('Correct: The size is 0.')
    else:
        print('ERROR: The size is %d instead of 0.' % queue2.size())
    if queue2.is_empty():
        print('Correct: The queue is empty.')
    else:
        print('ERROR: The queue should be empty.')

    print('\nAttempting to call first on an empty queue...')
    try:
        queue2.first()
        print('ERROR: No exception was thrown from first')
    except datastructures.EmptyCollectionError:
        print('Correct: Caught an EmptyCollectionError')
    except Exception:
        print('ERROR: Caught the wrong kind of exception')

    print('\nAttempting to call dequeue on an empty queue...')
    try:
        queue2.dequeue()
        print('ERROR: No exception was thrown from dequeue')
    except datastructures.EmptyCollectionError:
        print('Correct: Caught an EmptyCollectionError')
    except Exception:
        print('ERROR: Caught the wrong kind of exception')

    print('\nEnd of testing for the Queue class.')

main()
