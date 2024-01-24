import { LinkProps, Link as MuiLink } from '@mui/material';
import { Link as RouterLink } from 'react-router-dom';

export function Link(props: LinkProps<typeof RouterLink>) {
  return <MuiLink component={RouterLink} {...props} />;
}
