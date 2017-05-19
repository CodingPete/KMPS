#import <Foundation/Foundation.h>

int main(int argc, char** argv)
{
  NSMutableArray<NSObject *> *numbers = [[NSMutableArray alloc] init];
  [numbers addObject:@42];
  NSString *s = (NSString)[numbers objectAtIndex:0];
  NSLog(@"%@", s);

  /*
  error: used type 'NSString' where arithmetic or pointer type is
    required
    NSString *s = (NSString)[numbers objectAtIndex:0];
  */

  /* Casten in NSString-Pointertyp statt NSString Typ */
  NSString *s = (NSString *)[numbers objectAtIndex:0];
}
