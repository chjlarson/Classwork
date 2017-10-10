# test_cylinder.py
#
# This program tests the functions of the cylinder module.

import cylinder

def main():
    print('This program tests the functions of the cylinder module.\n')
    print('Read the output carefully to check your functions.\n')

    print('For a cylinder of radius 1 and height 1, the volume')
    print('should be 3.142 and the surface area should be 12.566.')
    print('Computed values:  volume = %.3f, surface area = %.3f\n' \
        % (cylinder.compute_volume(1, 1), cylinder.compute_surface_area(1, 1)))

    print('For a cylinder of radius 0.1 and height 0.5, the volume')
    print('should be 0.016 and the surface area should be 0.377.')
    print('Computed values:  volume = %.3f, surface area = %.3f\n' \
        % (cylinder.compute_volume(0.1, 0.5), \
        cylinder.compute_surface_area(0.1, 0.5)))

    print('For a cylinder of radius 2 and height 1.5, the volume')
    print('should be 18.850 and the surface area should be 43.982.')
    print('Computed values:  volume = %.3f, surface area = %.3f\n' \
        % (cylinder.compute_volume(2, 1.5), \
        cylinder.compute_surface_area(2, 1.5)))

    print('For a cylinder of radius 0 and height 2, the volume should be 0')
    print('and the surface area should be 0.')
    print('Computed values:  volume = %.3f, surface area = %.3f\n' \
        % (cylinder.compute_volume(0, 2), \
        cylinder.compute_surface_area(0, 2)))

    # Tests for negative radius
    print('Getting ready to test exception handling...')
    try:
        cylinder.compute_volume(-0.1, 1)
        print('ERROR: No exception was thrown from compute_volume')
    except ValueError:
        print('Correct: ValueError was thrown from compute_volume ' \
            + 'for negative radius')
    except Exception:
        print('ERROR: Wrong exception type was thrown from compute_volume')

    try:
        cylinder.compute_surface_area(-0.1, 1)
        print('ERROR: No exception was thrown from compute_surface_area')
    except ValueError:
        print('Correct: ValueError was thrown from compute_surface_area ' \
            + 'for negative radius')
    except Exception:
        print('ERROR: Wrong exception type was thrown from compute_surface_area')

    try:
        cylinder.compute_volume(0.1, -0.1)
        print('ERROR: No exception was thrown from compute_volume')
    except ValueError:
        print('Correct: ValueError was thrown from compute_volume ' \
            + 'for negative height')
    except Exception:
        print('ERROR: Wrong exception type was thrown from compute_volume')

    try:
        cylinder.compute_surface_area(0.1, -0.1)
        print('ERROR: No exception was thrown from compute_surface_area')
    except ValueError:
        print('Correct: ValueError was thrown from compute_surface_area ' \
            + 'for negative height')
    except Exception:
        print('ERROR: Wrong exception type was thrown from compute_surface_area')

main()
