import { mdiMenu } from '@mdi/js';
import Icon from '@mdi/react';
import { AppBar, Box, Drawer, IconButton, styled, Toolbar, Typography } from '@mui/material';
import { useState } from 'react';
import { Link } from './Link';

const StyledLink = styled(Link)`
  padding: 0.35rem 0.7rem;
  transition: background-color 0.4s;
  border-radius: 1rem;

  &:hover {
    background-color: rgb(204, 225, 221);
  }
`;

const StyledDrawerLink = styled(Link)`
  padding: 1rem;
`;

export default function Header() {
  const [isDrawerOpen, setIsDrawerOpen] = useState(false);
  const links = [{ to: '/', text: 'Start Seite' }];

  const handleDrawerToggle = () => {
    setIsDrawerOpen((prevState) => !prevState);
  };

  return (
    <>
      <AppBar sx={headerStyle} elevation={0}>
        <Toolbar>
          <Typography style={headerTitleStyle}>V7</Typography>
          <IconButton
            color={'primary'}
            aria-label={'open drawer'}
            edge={'end'}
            onClick={handleDrawerToggle}
            sx={{ display: { sm: 'none' }, marginLeft: 'auto', marginRight: '10px' }}>
            <Icon path={mdiMenu} size={1.4} />
          </IconButton>
          <Box sx={linkGrid}>
            {links.map((link, index) => (
              <StyledLink key={index} to={link.to}>
                <Typography>{link.text}</Typography>
              </StyledLink>
            ))}
          </Box>
        </Toolbar>
      </AppBar>
      <Drawer
        variant="temporary"
        open={isDrawerOpen}
        onClose={handleDrawerToggle}
        ModalProps={{
          keepMounted: true,
        }}
        sx={{
          display: { xs: 'block', sm: 'none' },
          '& .MuiDrawer-paper': { boxSizing: 'border-box', width: '50%' },
        }}>
        <Box onClick={handleDrawerToggle} sx={{ textAlign: 'center', backgroundColor: '#eef2f2', height: '100%' }}>
          {links.map((link, index) => (
            <StyledDrawerLink key={index} to={link.to}>
              <Typography>{link.text}</Typography>
            </StyledDrawerLink>
          ))}
        </Box>
      </Drawer>
    </>
  );
}

const headerStyle = {
  backgroundColor: '#86C4FD',
  top: '2rem',
  borderRadius: 2,
  position: 'sticky' as const,
};

const linkGrid = {
  display: { xs: 'none', sm: 'flex' },
  marginLeft: 'auto',
  gap: '20px',
  flexWrap: 'wrap',
};

const headerTitleStyle = {
  fontSize: '18px',
  color: '#575756',
  marginLeft: '10px',
};
