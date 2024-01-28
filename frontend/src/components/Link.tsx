import { Link as JoyLink, LinkProps } from '@mui/joy';
import { Link as RouterLink } from 'react-router-dom';

export function Link(props: LinkProps<typeof RouterLink>) {
  return <JoyLink component={RouterLink} {...props} />;
}
