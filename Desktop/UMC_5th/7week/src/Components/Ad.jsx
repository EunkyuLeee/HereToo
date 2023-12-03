import React from 'react';

function Ad({ showAd }) {
  if (!showAd) return null;
  
  return (
    <img src="./Untitled.svg" alt="banner" width="100%"/>
  );
}

export default Ad;
